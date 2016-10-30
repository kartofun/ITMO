clear();

// initial datas
angle = input("α:")*%pi/180;
velocity = input("v:");
g = 10;

// trajectory parameters
t_max = 2 * velocity * sin(angle) / g;
y_max = velocity^2 * sin(angle)^2 / (2 * g);
x_max = velocity * cos(angle) * t_max;

t = [0:t_max/100:t_max];

x = velocity*cos(angle)*t;
y = velocity*sin(angle)*t - g*t.^2/2;

disp("t_max: " + string(t_max), "y_max: " + string(y_max), "x_max: " + string(x_max));
plot(x, y);
