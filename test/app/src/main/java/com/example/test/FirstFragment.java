package com.example.cansa_team;

import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cansa_team.Data.FirebaseData;
import com.example.cansa_team.Model.CauHoi;
import com.example.cansa_team.Model.ConnectionReceiver;
import com.example.cansa_team.Model.Results;
import com.example.cansa_team.Model.TienIch;
import com.example.cansa_team.adapter.ResultAdapter;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {
    private Button btnBackText;
    private RecyclerView listResult;
    private ImageView home;
    private TextView total;
    private TextView txtResult;

    private String totalResult;
    private ArrayList<Results> resultsArrayList;

    private int countResult;
    private int countTrueChose;
    private String flagCauHoi;
    private Intent intent;
    private ResultActivity resultAdapter;
    private String countDownTime;
    private DatabaseErrorHandler reference;
    private String result;
    private ArrayList<CauHoi> cauHois;
    private Boolean checkResult;
    private ArrayList<Integer> deathPoints;
    private int nameLisence;

    private static final String SUCCESS = "Đậu";
    private static final String FAIL = "Trượt";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        home = findViewById(R.id.home);
        total = findViewById(R.id.total);
        listResult = findViewById(R.id.listResult);
        txtResult = findViewById(R.id.txt_result);
        btnBackText = findViewById(R.id.btnBackText);

        //lấy dữ liệu từ màn hình QuestionActivity
        Map<String, String> user_result = new HashMap<String, String>();
        intent = getIntent();
        Bundle bundle = intent.getExtras();

        resultAdapter = new ResultAdapter(this);
        resultsArrayList = QuestionActivity.resultsArrayList;
        countResult = resultsArrayList.size();
        flagCauHoi = bundle.get(LoadActivity.FLAG).toString();
        countDownTime = bundle.getString(flagCauHoi + "count down");
        nameLisence = bundle.getInt(flagCauHoi + "name");

        //đếm số lượng câu đúng
        countTrueChose = TienIch.countTrueChoseResults(resultsArrayList);

        /* kiểm tra trượt/đậu
         *  lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
         * */

        cauHois = new ArrayList<>();
        switch (flagCauHoi) {
            case LoadActivity.BANG_A1:
                sendAndCheck(1,16,FirebaseData.randomCauHoiBangA1());
                break;
            case LoadActivity.BANG_A2:
                sendAndCheck(1,18,FirebaseData.randomCauHoiBangA2());
                break;
            case LoadActivity.BANG_A3_A4:
                sendAndCheck(2,18,FirebaseData.randomCauHoiBangA3_A4());
                break;
            case LoadActivity.BANG_B1:
                sendAndCheck(3,26,FirebaseData.randomCauHoiBangB1());
                break;
            case LoadActivity.BANG_B2_C_D_E_F:
                sendAndCheck(3,28,FirebaseData.randomCauHoiBangB2_C_D_E_F());
                break;
        }

        totalResult = countTrueChose + "/" + resultsArrayList.size();
        //hiển thị ra màn hình kết quả đậu trượt
        total.setText(totalResult);
        txtResult.setText(result);

        reference = LoadActivity.firebaseDatabase.getInstance().getReference("user's result");
        //Gửi dữ liệu kết quả lên FireBase
        user_result.put(result, totalResult);
        reference.push().setValue(user_result);

        // Set Event
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnBackText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(ResultActivity.this, QuestionActivity.class);
                Bundle bundle = new Bundle();

                //tạo cờ xác định loại bằng chuyển qua
                bundle.putParcelableArrayList(flagCauHoi, cauHois);
                bundle.putString(LoadActivity.FLAG, flagCauHoi);
                bundle.putString(flagCauHoi + "count down", countDownTime);
                bundle.putInt(flagCauHoi + "name", nameLisence);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //SetAdapter, Ham getResults()->ArrayList<Results>
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        listResult.setLayoutManager(gridLayoutManager);
        resultAdapter.setData(resultsArrayList);
        listResult.setAdapter(resultAdapter);
    }

    private void sendAndCheck(int n, int target, ArrayList<CauHoi> listCauHoi){
        deathPoints = TienIch.RandomDeathPoint(n, countResult);
        checkResult = TienIch.checkResult(resultsArrayList, deathPoints, target);
        result = checkResult ? SUCCESS : FAIL;
        cauHois = listCauHoi;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!ConnectionReceiver.isConnected()) {
            Intent intent = new Intent(ResultActivity.this, LoadActivity.class);
            startActivity(intent);
        }
    }
}
