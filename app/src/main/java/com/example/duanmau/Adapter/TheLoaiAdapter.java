package com.example.duanmau.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duanmau.Database.Database;
import com.example.duanmau.Database.TypeDAO;
import com.example.duanmau.Database.UserDAO;
import com.example.duanmau.Model.TheLoai;
import com.example.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiAdapter extends BaseAdapter {
    private List<TheLoai> theLoaiList;

    public TheLoaiAdapter(List<TheLoai> theLoaiList) {
        this.theLoaiList = theLoaiList;
    }

    @Override
    public int getCount() {
        return theLoaiList.size();
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_the_loai, viewGroup, false);
        TextView tvMaTheLoai = view.findViewById(R.id.tvTenTheLoai);
        TextView tvTenTheLoai = view.findViewById(R.id.tvTenTheLoai);
        TextView tvViTri = view.findViewById(R.id.tvViTri);
        TextView tvMoTa = view.findViewById(R.id.tvMoTa);
        TheLoai theLoai = theLoaiList.get(i);
        tvMaTheLoai.setText(theLoai.getMaTheLoai());
        tvTenTheLoai.setText(theLoai.getTenTheLoai());
        tvViTri.setText(theLoai.getViTri());
        tvMoTa.setText(theLoai.getMoTa());
        view.findViewById(R.id.btnXoaTheLoai).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TypeDAO typeDAO = new TypeDAO(new Database(viewGroup.getContext()));
                String maTheLoai = theLoaiList.get(i).getMaTheLoai();
                boolean ketQua = typeDAO.xoaTheLoai(maTheLoai);
                if (ketQua) {
                    Toast.makeText(viewGroup.getContext(), "Xoa Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();

                    theLoaiList.remove(i);
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
