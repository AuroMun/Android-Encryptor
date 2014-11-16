package com.example.application1;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	public final static String EXTRA_MESSAGE_1 = "com.example.myfirstapp.MESSAGE1";
	public final static String EXTRA_MESSAGE_2="com.example.myfirstapp.MESSAGE2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void delete(View view){
    	LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayout1);
    	layout.removeViewAt(1);
    }
    public String Encrypt(String s,int e,String z){
    	char[] a = new char[20];
    	char[] b;
    	b=s.toCharArray();
    	int i,c=0;
    	for(i=0;i<b.length;i++){
    		//a[i]=(char)(Character.getNumericValue(b[i]));
    		a[i]=(char)((((int)b[i]-(int)'a'+e*(int)(z.charAt(c)-'0')) % 100)+(int)'a');
    		c++; if(c==z.length())c=0;
    	}
    	//if(String.valueOf(a).replaceAll(" ","").length()==20)return "LOL";
    	return String.valueOf(a).trim();
    }
    public void sendMessage(View view){
    	//Intent intent=new Intent(this, DisplayMessageActivity.class);
    	EditText editText_1=(EditText) findViewById(R.id.edit_message_1);
    	EditText editText_2 = (EditText) findViewById(R.id.edit_message_2);
    	String message1= ((EditText) findViewById(R.id.edit_message_1)).getText().toString();
    	String message2=editText_2.getText().toString();
    	String Password=((EditText) findViewById(R.id.passPhrase)).getText().toString();
    	((EditText)(findViewById(R.id.edit_message_2))).setText(Encrypt(message1,1,Password));
    }
    public void sendMessageToDecrypt(View view){
    	//Intent intent=new Intent(this, DisplayMessageActivity.class);
    	EditText editText_1=(EditText) findViewById(R.id.edit_message_1);
    	EditText editText_2 = (EditText) findViewById(R.id.edit_message_2);
    	String message1= ((EditText) findViewById(R.id.edit_message_1)).getText().toString();
    	String message2=editText_2.getText().toString();
    	String Password=((EditText) findViewById(R.id.passPhrase)).getText().toString();
    	((EditText)(findViewById(R.id.edit_message_1))).setText(Encrypt(message2,-1,Password));
    }
}
