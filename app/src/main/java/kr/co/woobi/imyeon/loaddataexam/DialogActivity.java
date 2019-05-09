package kr.co.woobi.imyeon.loaddataexam;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void onOpenDialog(View view) {
        Dialog dlg=new Dialog(this);
        dlg.setTitle("exam");
        TextView textView=new TextView(this);
        textView.setText("contents");
        dlg.setContentView(R.layout.dialogtest); //xml 로 만든 뷰 붙이기
//        dlg.setContentView(textView); //코드로 만든 뷰 붙이기
        dlg.show();
    }

    public void onOpenAlertDialog(View view) {
        new AlertDialog.Builder(this).setTitle("AlertDialogExam")
                .setMessage("content")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("no", null)
                .setNeutralButton("cacel", null)
                .show();
    }
}
