package zz.com.passwordsecuritylevel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import zz.com.passwordsecuritylevel.util.StringUtils;
import zz.com.passwordsecuritylevel.view.PasswordSecurityLevelView;


public class MainActivity extends AppCompatActivity {

    private PasswordSecurityLevelView passwordSecurityLevelView;
    private EditText passwordEt;
    private TextView passwordSecurityTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordEt = (EditText)findViewById(R.id.password_et);
        passwordSecurityTv = (TextView)findViewById(R.id.passwordSecurityTv);
        passwordSecurityLevelView = (PasswordSecurityLevelView)findViewById(R.id.passwordSecurityLevelView);
        passwordEt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
                if(arg0.toString().length()>=6){
                    String password = arg0.toString();
                    if(!StringUtils.isEmpty(password)){
                        int level = StringUtils.getPasswordStrongth(arg0.toString());
                        String[] levelColors = {"#E0792D","#E0BC2D","#7DE02D"};
                        String[] levelString = {"低","中","高"};
                        passwordSecurityLevelView.setLevel(3, level, levelColors[level]);
                        passwordSecurityTv.setText(levelString[level]);
                    }
                }else{
                    passwordSecurityLevelView.setLevel(3, 1, "#DADAE0");
                    passwordSecurityTv.setText("无");
                }
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

    }

}




