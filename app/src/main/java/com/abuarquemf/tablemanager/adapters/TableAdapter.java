package com.abuarquemf.tablemanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.abuarquemf.tablemanager.R;
import com.abuarquemf.tablemanager.entities.Table;

import java.util.List;

/**
 * Created by animal505 on 29/12/17.
 */

public class TableAdapter extends BaseAdapter {

    private Context context;
    private List<Table> tables;

    public TableAdapter(Context context, List<Table> tables) {
        this.context = context;
        this.tables = tables;
    }

    @Override
    public int getCount() {
        return this.tables.size();
    }

    @Override
    public Object getItem(int i) {
        return this.tables.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.tables.get(i).getTableId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View guiView = view;
        if(guiView == null)
            guiView = LayoutInflater.from(context).inflate(R.layout.table_unit_layout, null);

        Table currentTable = (Table) getItem(i);
        TextView currentTableId = guiView.findViewById(R.id.tableUnit);
        currentTableId.setText(("Table " + currentTable.getTableId()));
        return guiView;
    }
}
