[ak,vk]=meshgrid(0:0.1:%pi,0:0.1:%pi);
ymax=vk.^2/2/9.8*(sin(ak*%pi/180)).^2;
mesh(ymax);
xtitle('$\huge ymax(v,a)$');
