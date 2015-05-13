package com.noobgrammer.dagger2gradlequickstartexample;

import android.os.Bundle;
import android.widget.TextView;

import com.example.SomeThirdPartyClass;

import butterknife.InjectViews;


public class OutputActivity extends BaseActivity {

    public static final String EXTRA_INPUT_ARRAY = "OutputActivityExtra_InputArray";

    @InjectViews({R.id.input0, R.id.input1, R.id.input2, R.id.input3, R.id.input4})
    TextView[] outputTexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_output);
        super.onCreate(savedInstanceState);

        int[] input = getIntent().getIntArrayExtra(EXTRA_INPUT_ARRAY);

        SomeThirdPartyClass someClass = new SomeThirdPartyClass(); // Here, I'm introducing a hard dependency which Dagger 2 will fix for us
        int[] sorted = someClass.sort(input);
        for(int i = 0; i < outputTexts.length; i++) {
            outputTexts[i].setText(String.valueOf(sorted[i]));
        }
        setToolbarTitleText(R.string.output_title);
    }

}
