package com.example.connect30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0=blue and 1=red
    int activePlayer=0;
    boolean gameIsActive=true;
    //2 means unplayed
    int[] gameState ={2,2,2,2,2,2,2,2,2};
    int[][] winningPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public  void DropIn(View view){
        ImageView counter= (ImageView) view;
        System.out.println(counter.getTag().toString());
        int tapeCounter=Integer.parseInt(counter.getTag().toString());

        if(gameState[tapeCounter]==2 && gameIsActive){
            gameState[tapeCounter]=activePlayer;
            counter.setTranslationY(-1000f);

            if(activePlayer==0){
                counter.setImageResource(R.drawable.first);
                activePlayer=1;
            }else{
                counter.setImageResource(R.drawable.second);
                activePlayer=0;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);
            for(int[] winningPositions:winningPosition){
                    if(gameState[winningPositions[0]]==gameState[winningPositions[1]]
                        &&gameState[winningPositions[1]]==gameState[winningPositions[2]]
                        &&gameState[winningPositions[0]]!=2){
                        //Someone has won

                        gameIsActive=false;
                        String winner="Red";
                       if(gameState[winningPositions[0]]==0) {
                           winner="Blue";
                       }

                        TextView msg=findViewById(R.id.winner_msg);
                        msg.setText(winner+" has won!");
                        LinearLayout layout=findViewById(R.id.play_again_layout);
                        layout.setVisibility(View.VISIBLE);
                    }else{
                        boolean gameIsOver=true;
                        for(int counterState:gameState){
                            if(counterState==2){
                                gameIsOver=false;
                            }
                        }
                        if(gameIsOver){
                            TextView msg=findViewById(R.id.winner_msg);
                            msg.setText("It's a draw!");
                            LinearLayout layout=findViewById(R.id.play_again_layout);
                            layout.setVisibility(View.VISIBLE);
                        }
                    }

            }
        }


    }

    public  void  playAgain(View view){
        gameIsActive=true;
        LinearLayout layout=findViewById(R.id.play_again_layout);
        layout.setVisibility(View.GONE);
        activePlayer=0;
        for (int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }

        ImageView img1=findViewById(R.id.first);
        ImageView img2=findViewById(R.id.second);
        ImageView img3=findViewById(R.id.third);
        ImageView img4=findViewById(R.id.fourth);
        ImageView img5=findViewById(R.id.fiveth);
        ImageView img6=findViewById(R.id.sixth);
        ImageView img7=findViewById(R.id.seventh);
        ImageView img8=findViewById(R.id.eightth);
        ImageView img9=findViewById(R.id.nineth);

        img1.setImageResource(0);
        img2.setImageResource(0);
        img3.setImageResource(0);
        img4.setImageResource(0);
        img5.setImageResource(0);
        img6.setImageResource(0);
        img7.setImageResource(0);
        img8.setImageResource(0);
        img9.setImageResource(0);




    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
