package io.mycat.sqlEngine.ast.expr.arithmeticExpr.bigDecimalOperator;

import io.mycat.sqlEngine.ast.expr.ValueExpr;
import io.mycat.sqlEngine.ast.expr.numberExpr.BigDecimalExpr;
import io.mycat.sqlEngine.context.RootSessionContext;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class BigDecimalMultipyExpr implements BigDecimalExpr {

  private final RootSessionContext context;
  private final ValueExpr left;
  private final ValueExpr right;

  @Override
  public BigDecimal getValue() {
    BigDecimal leftValue = (BigDecimal) left.getValue();
    if (leftValue == null) {
      return null;
    }
    BigDecimal rightValue = (BigDecimal) right.getValue();
    if (rightValue == null) {
      return null;
    }
    return leftValue.multiply(rightValue);
  }
}