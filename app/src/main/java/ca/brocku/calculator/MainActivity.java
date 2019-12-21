package ca.brocku.calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.Stack;

/**
 *
 * Author: Marshall Joseph
 *
 * Reference: mathparser.org
 * -> mXparser.jar used to handle parentheses/formula entry
 *
 * *** To enable formula entry -> Start new line with open bracket "(" ***
 * *** Formula entry will work automatically with this!                ***
 *
 */

public class MainActivity extends AppCompatActivity {

    Button button_num_0, button_num_1, button_num_2, button_num_3, button_num_4, button_num_5,
            button_num_6, button_num_7, button_num_8, button_num_9, button_add, button_subtract,
            button_multiply, button_divide, button_open_bracket, button_closed_bracket,
            button_decimal, button_memory_store, button_memory_recall, button_clear,
            button_clear_all, button_equals;

    TextView output;

    boolean formulaEntry = false;       //
    double currOperand = Double.NaN;
    double nextOperand = 0;
    double memoryOperand = 0;
    String storedOperator = "";
    String mostRecentlyPressed = "";
    String currText = "";
    Expression e = new Expression("0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Below code recalls for orientation change
        if (savedInstanceState != null) {
            currOperand = savedInstanceState.getDouble("currOperand");
            nextOperand = savedInstanceState.getDouble("nextOperand");
            memoryOperand = savedInstanceState.getDouble("memoryOperand");
            storedOperator = savedInstanceState.getString("storedOperator");
            mostRecentlyPressed = savedInstanceState.getString("mostRecentlyPressed");
            currText = savedInstanceState.getString("currText");
            formulaEntry = savedInstanceState.getBoolean("formulaEntry");
            e = new Expression(savedInstanceState.getString("e"));
        }
        setContentView(R.layout.calculator);
        setButtons();
        output.setText(currText);
    }

    private void setButtons() {

        button_num_0 = (Button) findViewById(R.id.num_0);
        button_num_1 = (Button) findViewById(R.id.num_1);
        button_num_2 = (Button) findViewById(R.id.num_2);
        button_num_3 = (Button) findViewById(R.id.num_3);
        button_num_4 = (Button) findViewById(R.id.num_4);
        button_num_5 = (Button) findViewById(R.id.num_5);
        button_num_6 = (Button) findViewById(R.id.num_6);
        button_num_7 = (Button) findViewById(R.id.num_7);
        button_num_8 = (Button) findViewById(R.id.num_8);
        button_num_9 = (Button) findViewById(R.id.num_9);
        button_add = (Button) findViewById(R.id.add);
        button_subtract = (Button) findViewById(R.id.subtract);
        button_multiply = (Button) findViewById(R.id.multiply);
        button_divide = (Button) findViewById(R.id.divide);
        button_open_bracket = (Button) findViewById(R.id.open_bracket);
        button_closed_bracket = (Button) findViewById(R.id.closed_bracket);
        button_decimal = (Button) findViewById(R.id.decimal);
        button_memory_store = (Button) findViewById(R.id.memory_store);
        button_memory_recall = (Button) findViewById(R.id.memory_recall);
        button_clear = (Button) findViewById(R.id.clear);
        button_clear_all = (Button) findViewById(R.id.clear_all);
        button_equals = (Button) findViewById(R.id.equals);
        output = (TextView) findViewById(R.id.output);

        button_num_0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    output.setText("0");
                }
                // Allow max size of 17 chars
                if (output.getText().length() < 14 && !mostRecentlyPressed.equals("+")
                        && !mostRecentlyPressed.equals("-") && !mostRecentlyPressed.equals("*")
                        && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s0", output.getText()));
                }
                mostRecentlyPressed = "0";
            }
        });

        button_num_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    output.setText("1");
                }
                // Allow max size of 17 chars
                if (output.getText().length() < 14 && !mostRecentlyPressed.equals("+")
                        && !mostRecentlyPressed.equals("-") && !mostRecentlyPressed.equals("*")
                        && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s1", output.getText()));
                }
                mostRecentlyPressed = "1";
            }
        });

        button_num_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    output.setText("2");
                }
                // Allow max size of 17 chars
                if (output.getText().length() < 14 && !mostRecentlyPressed.equals("+")
                        && !mostRecentlyPressed.equals("-") && !mostRecentlyPressed.equals("*")
                        && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s2", output.getText()));
                }
                mostRecentlyPressed = "2";
            }
        });

        button_num_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    output.setText("3");
                }
                // Allow max size of 17 chars
                if (output.getText().length() < 14 && !mostRecentlyPressed.equals("+")
                        && !mostRecentlyPressed.equals("-") && !mostRecentlyPressed.equals("*")
                        && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s3", output.getText()));
                }
                mostRecentlyPressed = "3";
            }
        });

        button_num_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    output.setText("4");
                }
                // Allow max size of 17 chars
                if (output.getText().length() < 14 && !mostRecentlyPressed.equals("+")
                        && !mostRecentlyPressed.equals("-") && !mostRecentlyPressed.equals("*")
                        && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s4", output.getText()));
                }
                mostRecentlyPressed = "4";
            }
        });

        button_num_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    output.setText("5");
                }
                // Allow max size of 17 chars
                if (output.getText().length() < 14 && !mostRecentlyPressed.equals("+")
                        && !mostRecentlyPressed.equals("-") && !mostRecentlyPressed.equals("*")
                        && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s5", output.getText()));
                }
                mostRecentlyPressed = "5";
            }
        });

        button_num_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    output.setText("6");
                }
                // Allow max size of 17 chars
                if (output.getText().length() < 14 && !mostRecentlyPressed.equals("+")
                        && !mostRecentlyPressed.equals("-") && !mostRecentlyPressed.equals("*")
                        && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s6", output.getText()));
                }
                mostRecentlyPressed = "6";
            }
        });

        button_num_7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    output.setText("7");
                }
                // Allow max size of 17 chars
                if (output.getText().length() < 14 && !mostRecentlyPressed.equals("+")
                        && !mostRecentlyPressed.equals("-") && !mostRecentlyPressed.equals("*")
                        && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s7", output.getText()));
                }
                mostRecentlyPressed = "7";
            }
        });

        button_num_8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    output.setText("8");
                }
                // Allow max size of 17 chars
                if (output.getText().length() < 14 && !mostRecentlyPressed.equals("+")
                        && !mostRecentlyPressed.equals("-") && !mostRecentlyPressed.equals("*")
                        && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s8", output.getText()));
                }
                mostRecentlyPressed = "8";
            }
        });

        button_num_9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    output.setText("9");
                }
                // Allow max size of 17 chars
                if (output.getText().length() < 14 && !mostRecentlyPressed.equals("+")
                        && !mostRecentlyPressed.equals("-") && !mostRecentlyPressed.equals("*")
                        && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s9", output.getText()));
                }
                mostRecentlyPressed = "9";
            }
        });

        button_open_bracket.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    output.setText("(");
                }
                // Allow max size of 17 chars
                if (output.getText().length() < 14 && !mostRecentlyPressed.equals("+")
                        && !mostRecentlyPressed.equals("-") && !mostRecentlyPressed.equals("*")
                        && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s(", output.getText()));
                }
                formulaEntry = true;
                mostRecentlyPressed = "(";
            }
        });

        button_closed_bracket.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    output.setText(")");
                }
                // Allow max size of 17 chars
                if (output.getText().length() < 14 && !mostRecentlyPressed.equals("+")
                        && !mostRecentlyPressed.equals("-") && !mostRecentlyPressed.equals("*")
                        && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s)", output.getText()));
                }
                formulaEntry = true;
                mostRecentlyPressed = ")";
            }
        });

        button_decimal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mostRecentlyPressed = ".";
                // Allow max of one decimal
                if (!output.getText().toString().contains(".")) {
                    output.setText(String.format("%s.", output.getText()));
                }
            }
        });

        button_clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Check for any chars first
                if (mostRecentlyPressed.equals("+") || mostRecentlyPressed.equals("-")
                        || mostRecentlyPressed.equals("*") || mostRecentlyPressed.equals("/")) {
                    storedOperator = "";
                    mostRecentlyPressed = String.valueOf(output.getText().charAt(output.length() - 1));
                } else if (output.getText().length() > 0 && !mostRecentlyPressed.equals("+") && !mostRecentlyPressed.equals("-")
                        && !mostRecentlyPressed.equals("*") && !mostRecentlyPressed.equals("/")) {
                    output.setText(String.format("%s", output.getText().subSequence(0, output.getText().length() - 1)));
                }
            }
        });

        button_clear_all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currOperand = Double.NaN;
                nextOperand = 0;
                memoryOperand = 0;
                storedOperator = "";
                mostRecentlyPressed = "";
                output.setText(String.format("%s", ""));
            }
        });

        button_memory_store.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Check for any chars first
                // Disabled for formulas
                if (output.getText().length() > 0 && !formulaEntry) {
                    memoryOperand = Double.parseDouble(output.getText().toString());
                }
            }
        });

        button_memory_recall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                output.setText(String.format(Double.toString(memoryOperand), ""));
            }
        });

        button_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (output.getText().toString().contains("(")) {
                    formulaEntry = true;
                }
                if (formulaEntry) {
                    output.setText(String.format("%s+", output.getText()));
                } else if (!mostRecentlyPressed.equals("+")) {
                    calculate();
                    storedOperator = "+";
                    mostRecentlyPressed = "+";
                    output.setText(String.format(Double.toString(currOperand), ""));
                }
            }
        });

        button_subtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (output.getText().toString().contains("(")) {
                    formulaEntry = true;
                }
                if (formulaEntry) {
                    output.setText(String.format("%s-", output.getText()));
                } else if (!mostRecentlyPressed.equals("-")) {
                    calculate();
                    storedOperator = "-";
                    mostRecentlyPressed = "-";
                    output.setText(String.format(Double.toString(currOperand), ""));
                }
            }
        });

        button_multiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (output.getText().toString().contains("(")) {
                    formulaEntry = true;
                }
                if (formulaEntry) {
                    output.setText(String.format("%s*", output.getText()));
                } else if (!mostRecentlyPressed.equals("*")) {
                    calculate();
                    storedOperator = "*";
                    mostRecentlyPressed = "*";
                    output.setText(String.format(Double.toString(currOperand), ""));
                }
            }
        });

        button_divide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (output.getText().toString().contains("(")) {
                    formulaEntry = true;
                }
                if (formulaEntry) {
                    output.setText(String.format("%s/", output.getText()));
                } else if (!mostRecentlyPressed.equals("/")) {
                    calculate();
                    storedOperator = "/";
                    mostRecentlyPressed = "/";
                    output.setText(String.format(Double.toString(currOperand), ""));
                }
            }
        });

        button_equals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculate();
                output.setText(String.format(Double.toString(currOperand), ""));
                storedOperator = "";
                mostRecentlyPressed = "=";
                currOperand = Double.NaN;
                formulaEntry = false;
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save instance state for rotation
        super.onSaveInstanceState(outState);
        currText = output.getText().toString();
        outState.putDouble("currOperand", currOperand);
        outState.putDouble("nextOperand", nextOperand);
        outState.putDouble("memoryOperand", memoryOperand);
        outState.putString("storedOperator", storedOperator);
        outState.putString("mostRecentlyPressed", mostRecentlyPressed);
        outState.putString("currText", currText);
        outState.putBoolean("formulaEntry", formulaEntry);
        outState.putString("e", e.getExpressionString());
    }

    private void calculate() {
        // Handles calculations
        if (!Double.isNaN(currOperand)) {
            if (!formulaEntry) {
                nextOperand = Double.parseDouble(output.getText().toString());
            } else {
                calculateFormula();
            }
            switch (storedOperator) {
                case "+":
                    currOperand += nextOperand;
                    break;
                case "-":
                    currOperand -= nextOperand;
                    break;
                case "*":
                    currOperand *= nextOperand;
                    break;
                case "/":
                    if (nextOperand == 0) {
                        currOperand = Double.NaN;
                    } else {
                        currOperand /= nextOperand;
                    }
                    break;
            }
        } else {
            try {
                if (formulaEntry) {
                    e = new Expression(output.getText().toString());
                    currOperand = e.calculate();
                } else {
                    currOperand = Double.parseDouble(output.getText().toString());
                }
            } catch (Exception e) {
            }
        }
    }

    private void calculateFormula() {
        // Handles formulas using external library mXparser
        e = new Expression(output.getText().toString());
        nextOperand = e.calculate();
    }

}
