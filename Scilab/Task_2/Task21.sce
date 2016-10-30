a=input("Угол броска в градусах а = ")*%pi/180;
v=input("Начальная скорость в м/с v = ");
g=9.8;

funcprot(0);
function [tmax, xmax, ymax]=calcMaxVariables(a, v)
    tmax=2*v*sin(a)/g;
    t=0:0.0001:tmax;
    x=v*cos(a)*t;
    y=v*sin(a)*t-g*(t.^2)/2;
    ymax=v.^2/(2*g)*(sin(a)).^2;
    xmax=v.^2/g*sin(2*a);
endfunction

[tmax,xmax,ymax]=calcMaxVariables(a,v);
t=[0:tmax/1000:tmax];

x=v*cos(a)*t;
y=v*sin(a)*t-g*t.^2/2;

plot(x,y,'b');
legend('$\huge y(x)$', , 4, %t);

xgrid(5, 1, 7);
xtitle('$\huge Заданиe\ 2.1$', '$\huge x, м$', '$\huge y, м$')

disp(tmax);
disp(xmax);
disp(ymax);
