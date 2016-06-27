package ua.com.smiddle.agent_scripting.core.model;

/**
 * Created by A.Osadchuk on 16.05.2016.
 */
public abstract class Executor {
    //Типы элементов скрипта
    public final static int ELEMENT_TYPE_SHOW_INFO = 0;
    public final static int ELEMENT_TYPE_ENTER_DATA = 1;
    public final static int ELEMENT_TYPE_CONDITION = 2;
    public final static int ELEMENT_TYPE_OPERATION = 3;
    public final static int ELEMENT_TYPE_EXTERNAL_DATA = 4;
    public final static int ELEMENT_TYPE_CONNECTOR = 5;
    public final static int ELEMENT_TYPE_OTHER_SCRIPT = 6;
    //Типы условий
    public final static int CONDITION_TYPE_DEFAULT = 0;
    public final static int CONDITION_TYPE_ALTERNATE = 1;
    public final static int CONDITION_TYPE_EXCEPTION = 2;
    //Типы данных в переменной
    public final static int DATA_TYPE_STRING = 0;
    public final static int DATA_TYPE_INTEGER = 1;
    public final static int DATA_TYPE_FLOAT = 2;
    public final static int DATA_TYPE_DATETIME = 3;
    public final static int DATA_TYPE_STRING_LIST = 4;
    public final static int DATA_TYPE_INTEGER_LIST = 5;
    public final static int DATA_TYPE_FLOAT_LIST = 6;
    //Тип отображения
    public final static int DISPLAY_OPTION_SINGLE = 0;
    public final static int DISPLAY_OPTION_CHECKBOX = 1;
    public final static int DISPLAY_OPTION_LIST_BOX = 2;
    public final static int DISPLAY_OPTION_COMBO_BOX = 3;
    public final static int DISPLAY_OPTION_RADIO = 4;
    //Тип передаваемых значений
    public final static int PARAM_IN = 0;
    public final static int PARAM_OUT = 1;
    //Тип логического действия в условиях
    public final static int LOGIC_OR = 0;
    public final static int LOGIC_AND = 1;
    //Тип сравнения в подУсловиях
    public final static int COMPARISON_MORE = 0;
    public final static int COMPARISON_MORE_EQUAL = 1;
    public final static int COMPARISON_LESS = 2;
    public final static int COMPARISON_LESS_EQUAL = 3;
    public final static int COMPARISON_EQUAL = 4;
    public final static int COMPARISON_NOT_EQUAL = 5;
    public final static int COMPARISON_CONTAIN = 6;
    //Результаты проверки
    public final static int RESULT_FALSE = 0;
    public final static int RESULT_TRUE = 1;
    public final static int RESULT_EXCEPTION = 2;
    //Тип арифметической операции в операциях
    public final static int ARITHMETIC_NO = 0;
    public final static int ARITHMETIC_PLUS = 1;
    public final static int ARITHMETIC_MINUS = 2;
    public final static int ARITHMETIC_MULTIPLY = 3;
    public final static int ARITHMETIC_DIVIDE = 4;
}
