a=input("Угол броска в градусах а = ")*%pi/180;
v=input("Начальная скорость в м/с v = ");
g=9.8;

vk=[0:v/1000:v];
yk=vk.^2/(2*g)*(sin(a))^2;

plot(vk, yk, 'g');
legend('$\huge v,м/c$', '$\huge y,м$');
xgrid(5, 1, 7);
