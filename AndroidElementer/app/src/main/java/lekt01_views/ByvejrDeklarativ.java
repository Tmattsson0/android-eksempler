package lekt01_views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dk.nordfalk.android.elementer.R;

/**
 * @author Jacob Nordfalk
 */
public class ByvejrDeklarativ extends AppCompatActivity implements OnClickListener {

  Button okKnap, annullerKnap;
  EditText editText;
  WebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.lekt01_byvejr); // Hvis layout ligger i res/layout/lekt01_byvejr.xmlejr.xml
    // findViewById() kan først kaldes efter setContentView()
    editText = (EditText) findViewById(R.id.editText);
    okKnap = (Button) findViewById(R.id.okKnap);
    annullerKnap = (Button) findViewById(R.id.annullerKnap);
    webView = (WebView) findViewById(R.id.webView);
    webView.loadUrl("http://javabog.dk");

    okKnap.setOnClickListener(this);
    annullerKnap.setOnClickListener(this);
  }

  public void onClick(View hvadBlevDerKlikketPå) {
    System.out.println("Der blev klikket på " + hvadBlevDerKlikketPå);
    if (hvadBlevDerKlikketPå == okKnap) {
      String valgtPostNr = editText.getText().toString();
      Toast.makeText(this, "Viser byvejr for " + valgtPostNr, Toast.LENGTH_LONG).show();
      webView.loadUrl("http://servlet.dmi.dk/byvejr/servlet/byvejr_dag1?by=" + valgtPostNr + "&mode=long");
    } else {
      Toast.makeText(this, "Denne knap er ikke implementeret endnu", Toast.LENGTH_LONG).show();
    }
  }
}
