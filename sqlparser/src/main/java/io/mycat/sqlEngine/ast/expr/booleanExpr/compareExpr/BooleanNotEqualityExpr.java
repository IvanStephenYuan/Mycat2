package io.mycat.sqlEngine.ast.expr.booleanExpr.compareExpr;

import io.mycat.sqlEngine.ast.expr.ValueExpr;
import io.mycat.sqlEngine.ast.expr.booleanExpr.BooleanExpr;
import io.mycat.sqlEngine.context.RootSessionContext;

import java.util.Objects;

public class BooleanNotEqualityExpr implements BooleanExpr {

  private final RootSessionContext context;
  private final ValueExpr left;
  private final ValueExpr right;

  public BooleanNotEqualityExpr(RootSessionContext context, ValueExpr left,
      ValueExpr right) {
    this.context = context;
    this.left = left;
    this.right = right;
  }

  @Override
  public Boolean test() {
    Object leftValue = left.getValue();

    if (leftValue==null){
      return null;
    }
    Object rightValue = right.getValue();
    if (rightValue==null){
      return null;
    }
    return !Objects.equals(leftValue, rightValue);
  }
}