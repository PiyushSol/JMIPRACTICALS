DECLARE
isPrime Number;
num Number;
i Number;
BEGIN
num :=&num;
for i in 2..num loop
if mod(num,i) = 0 then
isPrime:=0;
else
isPrime:=1;
end if;
end loop;
if(isPrime = 1) then
DBMS_OUTPUT.PUT_LINE('THE NUMBER IS PRIME');
else
DBMS_OUTPUT.PUT_LINE('THE NUMBER IS NOT PRIME');
end if;
end;

