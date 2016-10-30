xg=[0 0 3 3 5 5 6 6 8 6 6 8 8 6]; yg=[0 5 5 0 5 0 0 5 5 5 3 3 0 0];
x=0; y=0; xs=1; ys=1; xm=10*max(xg); ym=10*max(yg); vx=0;

f=figure(); f.figure_position=[200,200]; f.figure_size=[800,600]; f.background=4;
b1=uicontrol(f,'style','pushbutton','Position',[670 400 50 30],'Callback',"close(a); close(f); vx=1;",'BackgroundColor',[0.7,0.9,0.7],'ForegroundColor',[1,0,1],'String',"END");
a=newaxes(); a.axes_bounds=[0,0,1,1]; a.background = 4;  isoview(-xm,xm,-ym,ym);

while vx==0,
   xr=max(x+xg); yr=max(y+yg);
   if xr>xm-2 xs=-xs; end if yr>ym+8 ys=-ys; end if xr<-xm+10 xs=-xs; end if yr<-ym-3 ys=-ys; end
   x=x+xs; y=y+ys;
   plot(x+xg-xs,y+yg-ys,'c',x+xg,y+yg); 
end
