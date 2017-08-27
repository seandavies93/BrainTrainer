package com.sean.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random ans1=new Random();
    TextView answer1;
    TextView answer2;
    TextView answer3;
    TextView answer4;
    TextView question;
    TextView response;
    int[] ansnums=new int[4];
    int correctans;
    boolean multadd;
    int num1;
    int num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer1= (TextView) findViewById(R.id.text1);
        answer2= (TextView) findViewById(R.id.text2);
        answer3= (TextView) findViewById(R.id.text3);
        answer4= (TextView) findViewById(R.id.text4);
        question= (TextView) findViewById(R.id.textView);
        response= (TextView) findViewById(R.id.textView2);
    }
    public void setquestion()
    {
        multadd=ans1.nextBoolean();
        if(multadd)
        {
            num1=ans1.nextInt(100)+1;
            num2=ans1.nextInt(100)+1;
        }
        else
        {
            num1=ans1.nextInt(30)+1;
            num2=ans1.nextInt(30)+1;
        }
        correctans=ans1.nextInt(4);
    }
    public void setquestionans()
    {
        if(multadd)
        {
            question.setText(Integer.toString(num1)+"+"+Integer.toString(num2));
        }
        else
        {
            question.setText(Integer.toString(num1)+"*"+Integer.toString(num2));
        }
        for(int i=0 ; i<4 ; i++)
        {
            if(i==correctans)
            {
                if(multadd)
                {
                    ansnums[i] =num1+num2;
                }
                else
                {
                    ansnums[i] =num1*num2;
                }
            }
            else
            {
                if(multadd)
                {
                    ansnums[i]=ans1.nextInt(200)+1;
                    int diff=ansnums[i]-(num1+num2);
                    while((diff*diff)>100)
                    {
                            ansnums[i] = ans1.nextInt(200) + 1;
                            diff = ansnums[i] - (num1 + num2);
                    }

                }
                else
                {
                    ansnums[i]=ans1.nextInt(900)+1;
                    int diff=ansnums[i]-(num1*num2);
                    while((diff*diff)>500)
                    {
                            ansnums[i] = ans1.nextInt(900) + 1;
                            diff = ansnums[i] - (num1 * num2);
                    }

                }
            }
        }
        int duplicatecount=0;
        for (int i=0 ;i<4 ;i++)
        {
            for( int j=i+1 ; j<4; j++)
            {
                if(ansnums[i]==ansnums[j])
                {
                    duplicatecount++;
                }
            }
        }
        if(duplicatecount>0)
        {
            setquestionans();
        }
    }
    public void setansdisplay()
    {
        answer1.setText(Integer.toString(ansnums[0]));
        answer2.setText(Integer.toString(ansnums[1]));
        answer3.setText(Integer.toString(ansnums[2]));
        answer4.setText(Integer.toString(ansnums[3]));
    }
    public void start  (View view)
    {
        setquestion();
        setquestionans();
        setansdisplay();
    }
    public void action (View view)
    {
        switch(view.getId()) {
            case R.id.text1:
            {
                if(correctans==0)
                {
                    response.setText("Correct!");
                }
                else
                {
                    response.setText("Incorrect!");
                }
                break;
            }
            case R.id.text2:
            {
                if(correctans==1)
                {
                    response.setText("Correct!");
                }
                else
                {
                    response.setText("Incorrect!");
                }
                break;
            }
            case R.id.text3:
            {
                if(correctans==2)
                {
                    response.setText("Correct!");
                }
                else
                {
                    response.setText("Incorrect!");
                }
                break;
            }
            case R.id.text4:
            {
                if(correctans==3)
                {
                    response.setText("Correct!");
                }
                else
                {
                    response.setText("Incorrect!");
                }
                break;
            }

        }
        setquestion();
        setquestionans();
        setansdisplay();
    }

}
