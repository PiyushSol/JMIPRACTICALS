DECLARE
    NUM       NUMBER;
    PI        NUMBER:=3.1415;
    AREA      NUMBER:=0;
    PERIMETER NUMBER:=0;
BEGIN
    NUM:= &NUM;
    PERIMETER := (2*PI*NUM);
    AREA := (PI)*POWER(NUM, 2);
    DBMS_OUTPUT.PUT_LINE('The Area of Circle : '
                         ||AREA);
    DBMS_OUTPUT.PUT_LINE('The Perimeter of Circle : '
                         ||PERIMETER);
END;
/