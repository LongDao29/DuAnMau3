package com.example.duanmau.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duanmau.Database.Database;
import com.example.duanmau.Database.UserDAO;
import com.example.duanmau.Model.NguoiDung;
import com.example.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    List<NguoiDung> nguoiDungList;

    public NguoiDungAdapter(List<NguoiDung> nguoiDungList) {
        this.nguoiDungList = nguoiDungList;
    }

    @Override
    public int getCount() {
        return nguoiDungList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nguoi_dung, viewGroup, false);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvPhone = view.findViewById(R.id.tvPhone);
        NguoiDung nguoiDung = nguoiDungList.get(i);
        tvName.setText(nguoiDung.getTen());
        tvPhone.setText(nguoiDung.getPhone());
        view.findViewById(R.id.btnXoaNguoiDung).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDAO userDAO = new UserDAO(new Database(viewGroup.getContext()));
                String username = nguoiDungList.get(i).getUserName();
                boolean ketQua = userDAO.xoaNguoiDung(username);
                if (ketQua) {
                    Toast.makeText(viewGroup.getContext(), "Xoa Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();

                    nguoiDungList.remove(i);
                    notifyDataSetChanged();

                } else {
                    Toast.makeText(viewGroup.getContext(), "Xoa KHONG Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
