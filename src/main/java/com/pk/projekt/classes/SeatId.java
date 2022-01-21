package com.pk.projekt.classes;

import java.io.Serializable;

public class SeatId implements Serializable {

  private int row;
  private int column;

  public SeatId() {

  }

  public SeatId(int row, int column) {
    this.row = row;
    this.column = column;
  }
}
