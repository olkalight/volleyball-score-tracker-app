package com.example.android.volleyball_score_tracker_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int scoreHome;
    private int scoreGuest;
    private int setsHome;
    private int setsGuest;
    private TextView scoreViewHome;
    private TextView scoreViewGuest;
    private TextView setsViewHome;
    private TextView setsViewGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        scoreViewHome = (TextView) findViewById(R.id.home_team_score);
        setsViewHome = (TextView) findViewById(R.id.home_team_sets);
        scoreViewGuest = (TextView) findViewById(R.id.guest_team_score);
        setsViewGuest = (TextView) findViewById(R.id.guest_team_sets);
        Button pointHomeButton = (Button) findViewById(R.id.point_home_team);
        Button twoPointsHomeButton = (Button) findViewById(R.id.two_points_home_team);
        Button pointGuestButton = (Button) findViewById(R.id.point_guest_team);
        Button twoPointsGuestButton = (Button) findViewById(R.id.two_points_guest_team);
        Button resetButton = (Button) findViewById(R.id.reset);
        resetButton.setOnClickListener(this);
        pointHomeButton.setOnClickListener(this);
        twoPointsHomeButton.setOnClickListener(this);
        pointGuestButton.setOnClickListener(this);
        twoPointsGuestButton.setOnClickListener(this);

        scoreHome = scoreGuest = setsHome = setsGuest = 0;
    }

    public void displayForTeams(TextView view, int num) {
        view.setText(String.valueOf(num));
    }

    private void resetScores() {
        scoreHome = scoreGuest = 0;
        displayForTeams(scoreViewHome, scoreHome);
        displayForTeams(scoreViewGuest, scoreGuest);
    }

    private void resetSets() {
        setsHome = setsGuest = 0;
        displayForTeams(setsViewHome, setsHome);
        displayForTeams(setsViewGuest, setsGuest);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.reset): {
                resetScores();
                resetSets();
                break;
            }
            case (R.id.point_home_team): {
                scoreHome++;
                displayForTeams(scoreViewHome, scoreHome);
                if (scoreHome >= 25 && (scoreHome - scoreGuest) >= 2) {
                    Context context = getApplicationContext();
                    CharSequence message = "Home team wins this set!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, message, duration);
                    toast.show();

                    setsHome++;
                    displayForTeams(setsViewHome, setsHome);
                    resetScores();
                }
                break;
            }
            case (R.id.point_guest_team): {
                scoreGuest++;
                displayForTeams(scoreViewGuest, scoreGuest);
                if (scoreGuest >= 25 && (scoreGuest - scoreHome) >= 2) {
                    Context context = getApplicationContext();
                    CharSequence message = "Guest team wins this set!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, message, duration);
                    toast.show();

                    setsGuest++;
                    displayForTeams(setsViewGuest, setsGuest);
                    resetScores();
                }
                break;
            }
            case (R.id.two_points_home_team): {
                scoreHome += 2;
                displayForTeams(scoreViewHome, scoreHome);
                if (scoreHome >= 25 && (scoreHome - scoreGuest) >= 2) {
                    Context context = getApplicationContext();
                    CharSequence message = "Home team wins this set!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, message, duration);
                    toast.show();

                    setsHome++;
                    displayForTeams(setsViewHome, setsHome);
                    resetScores();
                }
                break;
            }
            case (R.id.two_points_guest_team): {
                scoreGuest += 2;
                displayForTeams(scoreViewGuest, scoreGuest);
                if (scoreGuest >= 25 && (scoreGuest - scoreHome) >= 2) {
                    Context context = getApplicationContext();
                    CharSequence message = "Guest team wins this set!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, message, duration);
                    toast.show();

                    setsGuest++;
                    displayForTeams(setsViewGuest, setsGuest);
                    resetScores();
                }
            }
            default:
                break;
        }
    }
}