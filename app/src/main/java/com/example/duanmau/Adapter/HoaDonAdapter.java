package com.example.duanmau.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duanmau.Database.BillDAO;
import com.example.duanmau.Database.Database;
import com.example.duanmau.Database.UserDAO;
import com.example.duanmau.Model.HoaDon;
import com.example.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class HoaDonAdapter extends BaseAdapter {
    List<HoaDon> hoaDonList = new ArrayList<>();

    public HoaDonAdapter(List<HoaDon> hoaDonList) {
        this.hoaDonList = hoaDonList;
    }

    @Override
    public int getCount() {
        return hoaDonList.size();
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_hoa_don, viewGroup, false);
        TextView tvMaHoaDon = view.findViewById(R.id.tvMaHoaDon);
        TextView tvMaSach = view.findViewById(R.id.tvMaSach);
        TextView tvNgayTao = view.findViewById(R.id.tvNgayTao);
        TextView tvSoLuong = view.findViewById(R.id.tvSoLuong);
        HoaDon hoaDon = hoaDonList.get(i);
        tvMaHoaDon.setText(hoaDon.getMaHD());
        tvMaSach.setText(hoaDon.getMaSach());
        tvNgayTao.setText(hoaDon.getNgayTao());
        tvSoLuong.setText(hoaDon.getNgayTao());
        view.findViewById(R.id.btnXoaHoaDon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BillDAO billDAO = new BillDAO(new Database(viewGroup.getContext()));
                String maHoaDon = hoaDonList.get(i).getMaHD();
                boolean ketQua = billDAO.xoaHoaDon(maHoaDon);
                if (ketQua) {
                    Toast.makeText(viewGroup.getContext(), "Xoa Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();

                    hoaDonList.remove(i);
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
