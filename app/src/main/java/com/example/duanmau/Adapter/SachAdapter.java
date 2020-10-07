package com.example.duanmau.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duanmau.Database.BookDAO;
import com.example.duanmau.Database.Database;
import com.example.duanmau.Database.UserDAO;
import com.example.duanmau.Model.Sach;
import com.example.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class SachAdapter extends BaseAdapter {
    private List<Sach> sachList = new ArrayList<>();

    public SachAdapter(List<Sach> sachList) {
        this.sachList = sachList;
    }

    @Override
    public int getCount() {
        return sachList.size();
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sach, viewGroup, false);
        TextView tvMaSach = view.findViewById(R.id.tvMaSach);
        TextView tvTenTheLoai = view.findViewById(R.id.tvTenTheLoai);
        TextView tvTenSach = view.findViewById(R.id.tvTenSach);
        TextView tvTacGia = view.findViewById(R.id.tvTacGia);
        TextView tvNXB = view.findViewById(R.id.tvNXB);
        TextView tvSoLuong = view.findViewById(R.id.tvSoLuong);
        TextView tvDonGia = view.findViewById(R.id.tvDonGia);
        Sach sach = sachList.get(i);
        tvMaSach.setText(sach.getMaSach());
        tvTenTheLoai.setText(sach.getTenTheLoai());
        tvTenSach.setText(sach.getTenSach());
        tvTacGia.setText(sach.getTacGia());
        tvNXB.setText(sach.getNhaXB());
        tvSoLuong.setText(sach.getSoLuong());
        tvDonGia.setText(String.valueOf(sach.getDonGia()));
        view.findViewById(R.id.btnXoaSach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookDAO bookDAO = new BookDAO(new Database(viewGroup.getContext()));
                String maSach = sachList.get(i).getMaSach();
                boolean ketQua = bookDAO.xoaSach(maSach);
                if (ketQua) {
                    Toast.makeText(viewGroup.getContext(), "Xoa Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();

                    sachList.remove(i);
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
