package com.joshi.nachiket.game_of_life;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class GameLife extends AppCompatActivity {

    public Button next_button;
    public Button reset_button;
    public Button start_button;
    public GridView gridview;
    ImageView imageView;

    public int findNeighbourCount (int position) {
        int neighbourCount;
        ImageView neighbourChild;
        ImageAdapter.ViewHolder neighbourHolder;
        int aliveCellCounter = 0;

        if((position-13) >= 0) {
            neighbourChild = (ImageView) gridview.getChildAt(position - 13);
            neighbourHolder = (ImageAdapter.ViewHolder) neighbourChild.getTag();
            if(!neighbourHolder.isAlive) {
                aliveCellCounter ++;
            }
        }

        if((position-12) >= 0) {
            neighbourChild = (ImageView) gridview.getChildAt(position - 12);
            neighbourHolder = (ImageAdapter.ViewHolder) neighbourChild.getTag();
            if(!neighbourHolder.isAlive) {
                aliveCellCounter ++;
            }
        }

        if((position-11) >= 0) {
            neighbourChild = (ImageView) gridview.getChildAt(position - 11);
            neighbourHolder = (ImageAdapter.ViewHolder) neighbourChild.getTag();
            if(!neighbourHolder.isAlive) {
                aliveCellCounter ++;
            }
        }

        if((position-1) >= 0) {
            neighbourChild = (ImageView) gridview.getChildAt(position - 1);
            neighbourHolder = (ImageAdapter.ViewHolder) neighbourChild.getTag();
            if(!neighbourHolder.isAlive) {
                aliveCellCounter ++;
            }
        }

        if((position+1) <= 179) {
            neighbourChild = (ImageView) gridview.getChildAt(position + 1);
            neighbourHolder = (ImageAdapter.ViewHolder) neighbourChild.getTag();
            if(!neighbourHolder.isAlive) {
                aliveCellCounter ++;
            }
        }

        if((position+11) <= 179) {
            neighbourChild = (ImageView) gridview.getChildAt(position + 11);
            neighbourHolder = (ImageAdapter.ViewHolder) neighbourChild.getTag();
            if(!neighbourHolder.isAlive) {
                aliveCellCounter ++;
            }
        }

        if((position+12) <= 179) {
            neighbourChild = (ImageView) gridview.getChildAt(position + 12);
            neighbourHolder = (ImageAdapter.ViewHolder) neighbourChild.getTag();
            if(!neighbourHolder.isAlive) {
                aliveCellCounter ++;
            }
        }

        if((position+13) <= 179) {
            neighbourChild = (ImageView) gridview.getChildAt(position + 13);
            neighbourHolder = (ImageAdapter.ViewHolder) neighbourChild.getTag();
            if(!neighbourHolder.isAlive) {
                aliveCellCounter ++;
            }
        }

        return aliveCellCounter;
    }

    public void prepareGrid (int aliveCellCounter[]) {

        for (int j=0; j< gridview.getChildCount();j++) {

            ImageView child = (ImageView) gridview.getChildAt(j);
            ImageAdapter.ViewHolder holder = (ImageAdapter.ViewHolder) child.getTag();

            if (!holder.isAlive) {
                if((aliveCellCounter[j] < 2) || (aliveCellCounter[j] > 3)){
                    holder.isAlive = !holder.isAlive;
                }
            } else {
                if (aliveCellCounter[j] == 3) {
                    holder.isAlive = !holder.isAlive;
                }
            }
        }

    }

    public void drawGrid() {

        for (int i=0; i<gridview.getChildCount();i++) {

            ImageView child = (ImageView) gridview.getChildAt(i);
            ImageAdapter.ViewHolder holder = (ImageAdapter.ViewHolder) child.getTag();

            if(holder.isAlive) {
                child.setImageDrawable(getResources().getDrawable(R.drawable.alivecell));
            } else {
                child.setImageDrawable(getResources().getDrawable(R.drawable.deadcell));
            }
        }
    }

    public int countAliveCells () {
        int countOfAliveCells = 0;

        for (int i=0; i<gridview.getChildCount();i++) {

            ImageView child = (ImageView) gridview.getChildAt(i);
            ImageAdapter.ViewHolder holder = (ImageAdapter.ViewHolder) child.getTag();

            if(!holder.isAlive) {
                countOfAliveCells ++;
            }
        }

        return countOfAliveCells;
    }

    public void next () {
        int aliveCellCounter[] = new int[180];
        for(int i=0; i<gridview.getChildCount(); i++) {
            aliveCellCounter[i] = findNeighbourCount(i);
            //Log.d("ALIVECOUNTER: ", aliveCellCounter + "POSITION: " + i);
        }
        prepareGrid(aliveCellCounter);
        drawGrid();
    }

    public void reset () {
        for (int i=0; i<gridview.getChildCount();i++) {

            ImageView child = (ImageView) gridview.getChildAt(i);
            ImageAdapter.ViewHolder holder = (ImageAdapter.ViewHolder) child.getTag();

            child.setImageDrawable(getResources().getDrawable(R.drawable.alivecell));
            holder.isAlive = true;

        }
    }

    public void start () {
        int countOfAliveCells = 0;
        //countOfAliveCells = countAliveCells();
    }

    public void nextButton () {
        next_button = (Button) findViewById(R.id.next);
        next_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Log.d("TAG", "NEXT BUTTON PRESSED YOUR LOGIC OF NEXT STEP IS HERE!");
                next();
            }
        });
    }

    public void resetButton () {
        reset_button = (Button) findViewById(R.id.reset);
        reset_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d("TAG", "RESET BUTTON PRESSED");
                reset();
            }
        });
    }

    public void startButton () {
        start_button = (Button) findViewById(R.id.start);
        start_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d("TAG", "START BUTTON PRESSED");
                //start();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_life);
        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View imgView, int position, long id) {

                ImageView imageView = (ImageView) imgView;
                ImageAdapter.ViewHolder holder = (ImageAdapter.ViewHolder) imageView.getTag();

                if(holder.isAlive) {
                    imageView.setImageResource(R.drawable.deadcell);
                } else {
                    imageView.setImageResource(R.drawable.alivecell);
                }
                holder.isAlive = !holder.isAlive;
            }
        });

        nextButton();
        startButton();
        resetButton();
    }
}
