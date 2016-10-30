fid=mopen('D:\ДОМАШКА\ПрОА\Tasks\Задание 4\dr_3k_12.txt','rt');
f=mfscanf(-1, fid, '%d %s %s %s %d %1s %d %1s %d');
studentsDays = [];
groupsDays = [];
studentDeviation = [];
studentDeviation7000 = [];
days = 0;
normalStudent = "";
student7000 = "";
groupp = f(1,1);
n = 0;
k = 0;

//Вычисление среднего по группе числа прожитых дней
disp("groupsDays: ");
j=0;
for i = 1 : 123
    if(groupp == f(i,1))
        days = days + int(datenum() - datenum(f(i,9), f(i,7), f(i,5)));
        n=n+1;
    else
        groupsDays($+1) = days/n;
        s="group "+string(f(i-1, 1));
        disp(s);
        disp(int(days/n));
        disp(n);
        n = 1;
        days = int(datenum() - datenum(f(i,9), f(i,7), f(i,5)));
        groupp = f(i,1);
    end
    if(i==123)
        groupsDays($+1) = days/n;
        s="group "+string(f(i-1, 1));
        disp(s);
        disp(int(days/n));
        n = 0;
        days = 0;
        groupp = f(i,1);
    end
end

//Вычисление прожитых дней для всех студентов
disp("studentsDays: ");
for i = 1 : 123
    studentsDays($+1) = string(int(datenum() - datenum(f(i,9), f(i,7), f(i,5))));
    days = days + int(datenum() - datenum(f(i,9), f(i,7), f(i,5)));
    v=datevec(datenum(f(i,9), f(i,7), f(i,5))+7000);
    studentDeviation7000($+1) = int(datenum(v(1), v(2), v(3))-datenum(v(1), 10, 1));
    disp(studentsDays($));
end

//Вычисление студента, наиболее близко подходящего к среднему числу прожитых дней
k = abs(int(days/123)-int(datenum() - datenum(f(1,9), f(1,7), f(1,5))));
normalStudent = f(1,1:9);
disp("averageDays: ");
disp(int(days/123));
for i = 1 : 123
    x = abs(int(days/123)-int(datenum() - datenum(f(i,9), f(i,7), f(i,5))));
    studentDeviation($+1) = x;
    if(k > x)
        k = x;
        normalStudent = f(i,1:9);
    end
end
disp("normalStudent: ");
disp(normalStudent);
days = 0;

//Вычисление студента, у которого первым будет 7000 дней со дня рождения, с октября
vectorDate=datevec(datenum(f(1,9), f(1,7), f(1,5))+7000);
minDeviation = int(datenum(vectorDate(1), vectorDate(2), vectorDate(3)) - datenum(vectorDate(1), 10, 1));
student7000 = f(1,1:9);
for i=1:123
    vectorDate=datevec(datenum(f(i,9), f(i,7), f(i,5))+7000);
    k = int(datenum(vectorDate(1), vectorDate(2), vectorDate(3))-datenum(vectorDate(1), 10, 1));
    if(k >= 0 & abs(minDeviation) > abs(k))
        minDeviation = k;
        student7000 = f(i,1:9);
    end
end
disp("student7000: ");
disp(student7000);

//Вывод в файл для каждого студента числа прожитых дней, отклонения от среднего и отклонения от 7000-го студента
fd=mopen('D:\ДОМАШКА\ПрОА\Tasks\Задание 4\text.txt','wt');
for i = 1:123
    mfprintf(fd, '%s %s\t\t\t%s\t\t\t%s\t\t\t%s\n', f(i,2), f(i,3), string(studentsDays(i)),string(studentDeviation(i)), string(studentDeviation7000(i)));
end
mclose('all');
