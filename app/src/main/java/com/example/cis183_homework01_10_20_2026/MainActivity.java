//Marcel Dahmoun
//10-25-26
//Allows users to choose an rgb value. Shows the value for red, green and blue, and also shows the hex value
//Users can also save colors and then choose those colors in a list


package
com.example.cis183_homework01_10_20_2026;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    Button btn_j_addColor;
    ListView lv_j_listOfColors;
    TextView tv_j_redValue;
    TextView tv_j_blueValue;
    TextView tv_j_greenValue;
    TextView tv_j_hexValue;
    SeekBar sb_j_redProgress;
    SeekBar sb_j_blueProgress;
    SeekBar sb_j_greenProgress;
    View main;

    int red = 255;
    int green = 255;
    int blue = 255;
    String hex = "FFFFFF";

    private ArrayList<ColorInfo> listOfColors;
    ColorListAdapter clAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_j_addColor = findViewById(R.id.btn_v_main_saveColor);
        lv_j_listOfColors = findViewById(R.id.lv_v_main_listOfColors);
        tv_j_redValue = findViewById(R.id.tv_v_main_redValue);
        tv_j_greenValue = findViewById(R.id.tv_v_main_greenValue);
        tv_j_blueValue = findViewById(R.id.tv_v_main_blueValue);
        tv_j_hexValue = findViewById(R.id.tv_v_main_hexValue);
        sb_j_redProgress = findViewById(R.id.sb_v_main_red);
        sb_j_greenProgress = findViewById(R.id.sb_v_main_green);
        sb_j_blueProgress = findViewById(R.id.sb_v_main_blue);
        main = findViewById(R.id.main);
        listOfColors = new ArrayList<>();

        clAdapter = new ColorListAdapter(this, listOfColors);
        lv_j_listOfColors.setAdapter(clAdapter);

        //Event Functions
        redChangedEvent();
        greenChangedEvent();
        blueChangedEvent();
        saveColorClickedEvent();
        onListViewClickedEvent();
    }

    //Event functions
    private void redChangedEvent()
    {
        sb_j_redProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                red = progress;
                main.setBackgroundColor(Color.rgb(red, green, blue));
                tv_j_redValue.setText("Red: " + progress);
                tv_j_hexValue.setText("Hex Value: " + Integer.toHexString(sb_j_redProgress.getProgress()) + Integer.toHexString(sb_j_greenProgress.getProgress()) + Integer.toHexString(sb_j_blueProgress.getProgress()));

                if (red == 0 && green <= 125 && blue <= 255)
                {
                    tv_j_redValue.setTextColor(Color.rgb(255,255,255));
                    tv_j_greenValue.setTextColor(Color.rgb(255,255,255));
                    tv_j_blueValue.setTextColor(Color.rgb(255,255,255));
                    tv_j_hexValue.setTextColor(Color.rgb(255,255,255));
                }
                else
                {
                    tv_j_redValue.setTextColor(Color.rgb(0,0,0));
                    tv_j_greenValue.setTextColor(Color.rgb(0,0,0));
                    tv_j_blueValue.setTextColor(Color.rgb(0,0,0));
                    tv_j_hexValue.setTextColor(Color.rgb(0,0,0));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    private void greenChangedEvent()
    {
        sb_j_greenProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                green = progress;
                main.setBackgroundColor(Color.rgb(red, green, blue));
                tv_j_greenValue.setText("Green: " + progress);
                tv_j_hexValue.setText("Hex Value: " + Integer.toHexString(sb_j_redProgress.getProgress()) + Integer.toHexString(sb_j_greenProgress.getProgress()) + Integer.toHexString(sb_j_blueProgress.getProgress()));


                if (red == 0 && green <= 125 && blue <= 255)
                {
                    tv_j_redValue.setTextColor(Color.rgb(255,255,255));
                    tv_j_greenValue.setTextColor(Color.rgb(255,255,255));
                    tv_j_blueValue.setTextColor(Color.rgb(255,255,255));
                    tv_j_hexValue.setTextColor(Color.rgb(255,255,255));
                }
                else
                {
                    tv_j_redValue.setTextColor(Color.rgb(0,0,0));
                    tv_j_greenValue.setTextColor(Color.rgb(0,0,0));
                    tv_j_blueValue.setTextColor(Color.rgb(0,0,0));
                    tv_j_hexValue.setTextColor(Color.rgb(0,0,0));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    private void blueChangedEvent()
    {
        sb_j_blueProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                blue = progress;
                main.setBackgroundColor(Color.rgb(red, green, blue));
                tv_j_blueValue.setText("Blue: " + progress);
                tv_j_hexValue.setText("Hex Value: " + Integer.toHexString(sb_j_redProgress.getProgress()) + Integer.toHexString(sb_j_greenProgress.getProgress()) + Integer.toHexString(sb_j_blueProgress.getProgress()));

                if (red == 0 && green <= 125 && blue <= 255)
                {
                    tv_j_redValue.setTextColor(Color.rgb(255,255,255));
                    tv_j_greenValue.setTextColor(Color.rgb(255,255,255));
                    tv_j_blueValue.setTextColor(Color.rgb(255,255,255));
                    tv_j_hexValue.setTextColor(Color.rgb(255,255,255));
                }
                else
                {
                    tv_j_redValue.setTextColor(Color.rgb(0,0,0));
                    tv_j_greenValue.setTextColor(Color.rgb(0,0,0));
                    tv_j_blueValue.setTextColor(Color.rgb(0,0,0));
                    tv_j_hexValue.setTextColor(Color.rgb(0,0,0));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    private void saveColorClickedEvent()
    {
        btn_j_addColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ColorInfo c = new ColorInfo(sb_j_redProgress.getProgress(), sb_j_greenProgress.getProgress(), sb_j_blueProgress.getProgress(), "test");
                listOfColors.add(c);

                clAdapter.notifyDataSetChanged();

                sb_j_redProgress.setProgress(255);
                sb_j_greenProgress.setProgress(255);
                sb_j_blueProgress.setProgress(255);
            }
        });
    }

    private void onListViewClickedEvent()
    {
        lv_j_listOfColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ColorInfo clickedColor = listOfColors.get(position);
                sb_j_redProgress.setProgress(clickedColor.getrValue());
                sb_j_greenProgress.setProgress(clickedColor.getgValue());
                sb_j_blueProgress.setProgress(clickedColor.getbValue());
            }
        });
    }
}