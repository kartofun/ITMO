funcprot(0);
function rating=convertRating(stringRating)
    rating = 0;
    select stringRating
    case 'A' then rating=5;
    case 'B' then rating=4.5;
    case 'C' then rating=4;
    case 'D' then rating=3.5;
    case 'E' then rating=3;
    case 'F' then rating=2;
    end
    select stringRating
    case 'А' then rating = 5;
    case 'В' then rating = 4.5;
    case 'С' then rating = 4;
    case 'Е' then rating = 3;
    end
endfunction

groupAll = [];
groupForRating = [];
groupp = [];
ratingAll = [];
rating = 0;

groupp($+1) = input("Введите номер группы: ", "string");

while 1 == 1
    if groupp($) == "0"
        disp("Ввод групп завершён");
        break;
    end

    while length(groupp($)) <> 5
        groupp(1) = input("Введите корректный номер группы(5 символов): ", "string");
    end
    
    student = input("Введите фамилию студента и оценку(Иванов A): ", "string");

    while(student <> "0")
        groupp($+1) = student;
        student = input("Введите фамилию студента и оценку: ", "string");
        disp(student);
    end
    
    for j=1:size(groupp, 'r')
        groupAll($+1) = groupp(j);
    end
    
    groupForRating($+1) = groupp(1);
    
    for j=2:size(groupp, 'r')
        x = convertRating(part(groupp(j), length(groupp(j))));
        rating = rating + x;
    end
    
    rating = rating/(size(groupp, 'r')-1);
    ratingAll($+1) = rating;
    
    groupp = [];
    rating = 0;
    groupp($+1) = input("Введите номер группы: ", "string");
end

for k=1:size(groupAll, 'r');
    disp(groupAll(k));
end

for l=1:size(groupForRating, 'r')
   k='|'+string(groupForRating(l));
   k=k+'|';
   k=k+string(ratingAll(l))+'|';
   disp(k); 
end
