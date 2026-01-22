/**
 * Copyright (C) 2010 dennis zhuang (killme2008@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 **/


package com.googlecode.aviator.lexer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.googlecode.aviator.lexer.token.Token;
import com.googlecode.aviator.lexer.token.Variable;


/**
 * Symbol table
 *
 * @author dennis
 *
 */
public class SymbolTable implements Serializable {

  private static final long serialVersionUID = -9019014977807517193L;

  private final Map<String, Variable> table = new HashMap<>();

  private static final Map<String, Variable> RESERVED = new HashMap<>();

  private static void reserveKeyword(final Variable v) {
    RESERVED.put(v.getLexeme(), v);
  }

  static {
    reserveKeyword(Variable.TRUE);
    reserveKeyword(Variable.FALSE);
    reserveKeyword(Variable.NIL);
    reserveKeyword(Variable.LAMBDA);
    reserveKeyword(Variable.FN);
    reserveKeyword(Variable.END);
    reserveKeyword(Variable.IF);
    reserveKeyword(Variable.ELSE);
    reserveKeyword(Variable.FOR);
    reserveKeyword(Variable.IN);
    reserveKeyword(Variable.RETURN);
    reserveKeyword(Variable.BREAK);
    reserveKeyword(Variable.CONTINUE);
    reserveKeyword(Variable.LET);
    reserveKeyword(Variable.WHILE);
    reserveKeyword(Variable.ELSIF);
    reserveKeyword(Variable.TRY);
    reserveKeyword(Variable.CATCH);
    reserveKeyword(Variable.FINALLY);
    reserveKeyword(Variable.THROW);
    reserveKeyword(Variable.NEW);
    reserveKeyword(Variable.USE);
  }

  public static boolean isReservedKeyword(final String name) {
    return RESERVED.containsKey(name);
  }

  public static boolean isReservedKeyword(final Variable v) {
    return isReservedKeyword(v.getLexeme());
  }


  /**
   * Check variable has been reserved?
   *
   * @param name
   * @return
   */
  public boolean isReserved(final String name) {
    return isReservedKeyword(name) || this.table.containsKey(name);
  }

  /**
   * Try to reserve key word, return the reserved variable if success, otherwise return itself.
   * 
   * @param var
   * @return
   */
  public static Variable tryReserveKeyword(final Variable var) {
    Variable reserve = RESERVED.get(var.getLexeme());
    return reserve != null ? reserve : var;
  }

  /**
   * Get variable by name
   *
   * @param name
   * @return
   */
  public Variable getVariable(final String name) {
    Variable var = RESERVED.get(name);
    return var != null ? var : this.table.get(name);
  }

  public Variable reserve(final String lexeme) {
    if (isReserved(lexeme)) {
      return getVariable(lexeme);
    } else {
      final Variable var = new Variable(lexeme, 0, -1);
      this.table.put(lexeme, var);
      return var;
    }
  }

  public Token<?> reserve(final Variable variable) {
    String lexeme = variable.getLexeme();
    if (isReserved(lexeme)) {
      Variable v = getVariable(lexeme);
      if (v.getStartIndex() < 0) {
        return v;
      }
      variable.setLexeme(v.getLexeme());
      return variable;
    } else {
      final String name = lexeme;
      this.table.put(name, variable);
      return variable;
    }
  }
}
