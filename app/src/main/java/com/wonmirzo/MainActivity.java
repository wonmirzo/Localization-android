package com.wonmirzo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        TextView tvCountry = findViewById(R.id.tvCountry);
        TextView tvCapitalCity = findViewById(R.id.tvCapitalCity);
        TextView tvLanguage = findViewById(R.id.tvLanguage);
        TextView tvCurrency = findViewById(R.id.tvCurrency);

        tvCountry.setText(getString(R.string.country));
        tvCapitalCity.setText(getString(R.string.capital_city));
        tvLanguage.setText(getString(R.string.language));
        tvCurrency.setText(getString(R.string.currency));

        Button btnEnglish = findViewById(R.id.btnEnglish);
        Button btnUzbek = findViewById(R.id.btnUzbek);
        Button btnChinese = findViewById(R.id.btnChinese);
        Button btnKorean = findViewById(R.id.btnKorean);
        Button btnJapanese = findViewById(R.id.btnJapanese);

        btnEnglish.setOnClickListener(view -> {
            setLocale("en");
        });
        btnUzbek.setOnClickListener(view -> {
            setLocale("uz");
        });
        btnChinese.setOnClickListener(view -> {
            setLocale("zh");
        });
        btnKorean.setOnClickListener(view -> {
            setLocale("ko");
        });
        btnJapanese.setOnClickListener(view -> {
            setLocale("ja");
        });
    }

    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        finish();
        startActivity(getIntent());
    }
}