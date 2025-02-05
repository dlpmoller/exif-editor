package com.moller.ViewModifications;

import com.moller.Models.ComboItem;

import javafx.scene.control.ListCell;

public class ComboItemListCell extends ListCell<ComboItem> {
    @Override
    protected void updateItem(ComboItem item, boolean isEmpty) {
        super.updateItem(item, isEmpty);
        if (isEmpty) {
            setText(null);
        } else {
            setText(item.GetAlias());
        }
    }
}
