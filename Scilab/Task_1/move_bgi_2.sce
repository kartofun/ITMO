function c=cvet()
    n=getdate(); rand("seed",n(10)); c=round(1+rand(1)*15); if c==4 then c=5; end
endfunction

xg=[0 0 3 3 5 5 6 6 8 6 6 8 8 6]; yg=[0 5 5 0 5 0 0 5 5 5 3 3 0 0];
x=0; y=0; xs=1; ys=1; xm=10*max(xg); ym=10*max(yg); vx=0;

//n=getdate(); rand("seed",n(10)); c=round(1+rand(1)*8);

f=figure(); f.figure_position=[200,200]; f.figure_size=[800,600]; f.background=4;
b1=uicontrol(f,'style','pushbutton','Position',[670 400 50 30],'Callback',"vx=1; close(a); close(f);",'BackgroundColor',[0.7,0.9,0.7],'ForegroundColor',[1,0,1],'String',"END");
f
a=newaxes(); a.axes_bounds=[0,0,1,1]; a.background = 4; isoview(-xm,xm,-ym,ym); plot(x+xg,y+yg); 
l=a.children.children; funcprot(0); l.thickness = 2; l.foreground = cvet();

while vx==0,
   xr=max(l.data(:,1)+xg'); yr=max(l.data(:,2)+yg');
   if xr>xm+6 xs=-xs; l.foreground = cvet(); end 
   if yr>ym+13 ys=-ys; l.foreground = cvet(); end 
   if xr<-xm+18 xs=-xs; l.foreground = cvet(); end 
   if yr<-ym+2 ys=-ys; l.foreground = cvet(); end
   l.data(:,1)=l.data(:,1)+xs; l.data(:,2)=l.data(:,2)+ys; xpause(10000);
end
