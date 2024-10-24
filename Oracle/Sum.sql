DECLARE
j integer;
sums INTEGER:=0;
BEGIN
for j in 1..10 LOOP
sums := sums + j;
END LOOP;
DBMS_OUTPUT.PUT_LINE('The Sum of first 10 natural numbers is : ');
DBMS_OUTPUT.PUT_LINE(sums);
end;
/