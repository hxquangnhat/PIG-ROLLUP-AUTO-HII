SET DEFAULT_PARALLEL 20;
REGISTER file:/home/hoang/piggybank-0.12.0.jar;
DEFINE UnixToISO org.apache.pig.piggybank.evaluation.datetime.convert.UnixToISO();
A = LOAD 'input' AS (inDate: int);
B = FOREACH A GENERATE UnixToISO(inDate*1000) as timestamp;
C = FOREACH B GENERATE GetYear(ToDate(timestamp)) as year:int, GetMonth(ToDate(timestamp)) as month:int, GetDay(ToDate(timestamp)) as day:int, GetHour(ToDate(timestamp)) as hour:int, GetMinute(ToDate(timestamp)) as minute:int, GetSecond(ToDate(timestamp)) as second:int;
D = CUBE C BY ROLLUP(year, month, day, hour, minute, second) CHUNKSIZE 1048576 RATE 0.3;
E = FOREACH D GENERATE group, COUNT_STAR(cube);
STORE E INTO 'output/rdns';
