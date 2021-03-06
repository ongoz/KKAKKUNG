package com.exitpoint.kkakkung;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.exitpoint.kkakkung.library.*;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ContentFragment())
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class ContentFragment extends Fragment implements AdapterView.OnItemClickListener {

        private ListView demosListView;


        public ContentFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] items = { "1",
                    "2. circular test",
                    "3. sample",
                    "4. Drag Test",
                    "5. sample2"
            };
            ArrayAdapter<String> simpleAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
            demosListView = (ListView) rootView.findViewById(R.id.demosListView);
            demosListView.setAdapter(simpleAdapter);
            demosListView.setOnItemClickListener(this);
            return rootView;
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0: //1. 액티비티 추가
                        //2. 매니페스트에 추가
                        //3. 레이아웃 추가
                        //4. 아래 양식대로 넣으면 아마 될지도..
                    Toast.makeText(getActivity().getApplicationContext(),
                            "1번!!",Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(getActivity(), Sample2Activity.class));
                    break;
                case 1:
                    startActivity(new Intent(getActivity(), CircularTest.class));
                    break;
                case 2:
                    startActivity(new Intent(getActivity(), SampleActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(getActivity(), DragTestActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(getActivity(), Sample2.class));
                    break;
            }
        }

    }
}
