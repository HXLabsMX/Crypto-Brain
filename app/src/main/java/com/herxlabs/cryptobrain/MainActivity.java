package com.herxlabs.cryptobrain;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txtToCrypt)TextView toCrypt;
    @BindView(R.id.txtCrypted)TextView crypted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.btnCrypt)
    public void crypt() {
        String crypto = toCrypt.getText().toString().toUpperCase();
        crypto = crypto.replace("A", "4");
        crypto = crypto.replace("B", "8");
        crypto = crypto.replace("E", "3");
        crypto = crypto.replace("G", "6");
        crypto = crypto.replace("I", "1");
        crypto = crypto.replace("O", "0");
        crypto = crypto.replace("P", "9");
        crypto = crypto.replace("S", "5");
        crypto = crypto.replace("T", "7");
        crypto = crypto.replace("Z", "2");
        crypto = crypto.replace("-", "--");
        crypto = crypto.replace(" ", "-");
        crypted.setText(crypto);
        //Oculta teclado
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        //Mensaje
        Context context = getApplicationContext();
        Toast toastMessage = Toast.makeText(context, "CryptoBrained", Toast.LENGTH_SHORT);
        toastMessage.show();
    }
    @OnClick(R.id.btnClear)
    public void clear() {
        toCrypt.setText("");
        crypted.setText("");
    }
    @OnClick(R.id.btnCopy)
    public void copy() {
        Context context = getApplicationContext();
        String copyCrypt = crypted.getText().toString();
        if (copyCrypt.length() > 0) {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("CryptoBrain", copyCrypt);
            clipboard.setPrimaryClip(clip);
            Toast toastMessage = Toast.makeText(context, "Text copied", Toast.LENGTH_LONG);
            toastMessage.show();
        } else {
            Toast toastMessage = Toast.makeText(context, "Nothing to copy", Toast.LENGTH_SHORT);
            toastMessage.show();
        }
    }
    @OnClick(R.id.btnShare)
    public void share() {
        String shareCrypt = crypted.getText().toString();
        if (shareCrypt.length() > 0) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, shareCrypt);
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
        } else {
            Context context = getApplicationContext();
            Toast toastMessage = Toast.makeText(context, "Nothing to share", Toast.LENGTH_SHORT);
            toastMessage.show();
        }
    }
}
