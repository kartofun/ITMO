clear();


function [y_max, x_max, t_max]= f(angle, velocity)
    g = 10;
    t_max = 2 * velocity * sin(angle) / g;
    y_max = velocity^2 * sin(angle).^2 / (2 * g);
    x_max = velocity * cos(angle) .* t_max;
endfunction

a = input("α:")*%pi/180;
v = input("v:");

[y, x, t] = f(a, v);

disp("t_max: " + string(t), "y_max: " + string(y), "x_max: " + string(x));

a = [0:0.01:%pi/2];
v = 100;

[y, x, t] = f(a, v);
plot(a*180/%pi, x);
xlabel("$\alpha, град$", "fontsize", 4);
ylabel("$x_{m}, м$", "fontsize", 4);
title("$x_{m}(\alpha)$", 'fontsize',5);
legend("v = " + string(v) + " м/с", 2);
xgrid(12, 0.5, 3);
