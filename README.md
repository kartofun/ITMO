# How to use Git

```bash
# Клонируем репозиторий, если у нас его еще нет.
git clone https://github.com/kartofun/ITMO.git 
# Переходим в склонированную дирректорию с помощью cd.
cd ITMO

# Изменяем файлы, затем добавляем их в Git.
git add --all
# Проверяем, все ли добавлено верно. 
git status
# Делаем commit.
git commit
# Пушим на удаленный репозиторий. (На GitHub)
git push origin master
# Повторяем с пункта git add.

# Можем смотреть историю коммитов с помощью git log. 
```
