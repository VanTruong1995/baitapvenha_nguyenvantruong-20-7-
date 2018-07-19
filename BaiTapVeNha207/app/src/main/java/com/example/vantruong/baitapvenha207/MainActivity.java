package com.example.vantruong.baitapvenha207;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etTen, etTuoi, etDiaChi;
    Button btSua, btThem, btXoa;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Data> list = new ArrayList<>();
        list.clear();
        // Anh xa dia chi voi xml.
        etTen = (EditText) findViewById(R.id.et_ten);
        etTuoi = (EditText) findViewById(R.id.et_tuoi);
        etDiaChi = (EditText) findViewById(R.id.et_dia_chi);
        btSua = (Button) findViewById(R.id.bt_sua);
        btThem = (Button) findViewById(R.id.bt_them);
        btXoa = (Button) findViewById(R.id.bt_xoa);

        // Xu ly recyclerView.
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        final Adapter adapter = new Adapter(MainActivity.this, list);
        recyclerView.setAdapter(adapter);

        // Bam Button them thi them thong tin vao data.
        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etTen.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập Tên", Toast.LENGTH_LONG).show();
                } else {
                    if (etTuoi.getText().toString().length() == 0) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập Tuổi", Toast.LENGTH_LONG).show();
                    } else {
                        if (etDiaChi.getText().toString().length() == 0) {
                            Toast.makeText(MainActivity.this, "Vui lòng nhập Địa chỉ", Toast.LENGTH_LONG).show();
                        } else {
                            Data data = new Data(etTen.getText().toString(), etTuoi.getText().toString(), etDiaChi.getText().toString());
                            etTen.setText("");
                            etTuoi.setText("");
                            etDiaChi.setText("");
                            list.add(data);
                            adapter.setList(list);
                            recyclerView.setAdapter(adapter);
                        }
                    }
                }
            }
        });

        // Bam Button sua thi sua vao vi tri chon item.
        btSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int viTri = adapter.getViTri();
                boolean a = adapter.isListenClickItem();
                if (list.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Danh sách của bạn không có thành viên nào", Toast.LENGTH_LONG).show();
                } else {
                    if (!a) {
                        Toast.makeText(MainActivity.this, "Vui lòng chọn Item cần sửa", Toast.LENGTH_LONG).show();
                    } else {
                        if (etTen.getText().toString().length() == 0) {
                            Toast.makeText(MainActivity.this, "Vui lòng nhập Tên cần sửa", Toast.LENGTH_LONG).show();
                        } else {
                            if (etTuoi.getText().toString().length() == 0) {
                                Toast.makeText(MainActivity.this, "Vui lòng nhập Tuổi cần sửa", Toast.LENGTH_LONG).show();
                            } else {
                                if (etDiaChi.getText().toString().length() == 0) {
                                    Toast.makeText(MainActivity.this, "Vui lòng nhập Địa chỉ cần sửa", Toast.LENGTH_LONG).show();
                                } else {
                                    Data data = new Data(etTen.getText().toString(), etTuoi.getText().toString(), etDiaChi.getText().toString());
                                    etTen.setText("");
                                    etTuoi.setText("");
                                    etDiaChi.setText("");
                                    list.set(viTri, data);
                                    adapter.setList(list);
                                    recyclerView.setAdapter(adapter);
                                }
                            }
                        }
                    }
                }


            }
        });

        // Bam Button xoa thi xoa vi tri item duoc chon.
        btXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int viTri = adapter.getViTri();
                boolean a = adapter.isListenClickItem();
                if (list.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Danh sách của bạn không có thành viên nào", Toast.LENGTH_LONG).show();
                } else {
                    if (!a) {
                        Toast.makeText(MainActivity.this, "Vui lòng chọn Item cần xóa", Toast.LENGTH_LONG).show();
                    } else {
                        list.remove(viTri);
                        adapter.setList(list);
                        recyclerView.setAdapter(adapter);
                    }
                }
            }
        });
    }
}
