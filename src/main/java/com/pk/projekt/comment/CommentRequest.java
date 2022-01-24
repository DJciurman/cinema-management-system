package com.pk.projekt.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentRequest {
  Integer mark;
  String comment;
  Integer movieId;
}
