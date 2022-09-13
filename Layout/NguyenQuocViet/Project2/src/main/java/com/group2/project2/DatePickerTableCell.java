/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2;

import java.time.LocalDate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author Darkin
 */
public class DatePickerTableCell<T> extends TableCell<T, LocalDate> {

    private final DatePicker datePicker;
    private boolean listening = true;

    // listener for changes in the datepicker
    private final ChangeListener<LocalDate> listener = (observable, oldValue, newValue) -> {
        if (listening) {
            listening = false;

            TableColumn<T, LocalDate> column = getTableColumn();
            EventHandler<TableColumn.CellEditEvent<T, LocalDate>> handler = column.getOnEditCommit();
            if (handler != null) {
                // use TableColumn.onEditCommit if there is a handler
                handler.handle(new TableColumn.CellEditEvent<>(
                        (TableView<T>) getTableView(),
                        new TablePosition<T, LocalDate>(getTableView(), getIndex(), column),
                        TableColumn.<T, LocalDate>editCommitEvent(),
                        newValue
                ));
            } else {
                // otherwise check if ObservableValue from cellValueFactory is
                // also writable and use in that case
                ObservableValue<LocalDate> observableValue = column.getCellObservableValue((T) getTableRow().getItem());
                if (observableValue instanceof WritableValue) {
                    ((WritableValue) observableValue).setValue(newValue);
                }
            }

            listening = true;
        }
    };

    public DatePickerTableCell() {
        this.datePicker = new DatePicker();
        this.datePicker.valueProperty().addListener(listener);
    }

    @Override
    protected void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            listening = false;
            setGraphic(null);
        } else {
            listening = false;
            setGraphic(this.datePicker);
            this.datePicker.setValue(item);
            listening = true;
        }
    }

    public static <E> Callback<TableColumn<E, LocalDate>, TableCell<E, LocalDate>> forTableColumn() {
        return column -> new DatePickerTableCell<>();
    }

}