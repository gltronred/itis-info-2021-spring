# ДЗ

Все ДЗ должны быть в папке `homeworks`, в папках по номерам (`1`, `2`, ...), файлы (`P1.java` в `1`, `P2.java` в `2` и т.д.).

## 1

Вводится число `N (1 <= N <= 10000)`.

Вывести список из `N` первых простых чисел через пробел.

(назвать файл `P1.java`, в папке `1`, реализовать `main`)

**Подсказка.** Заведите список простых чисел и для проверки следующего числа на простоту используйте те числа, которые есть.

Подумайте, что будет эффективнее для этой задачи: ArrayList или LinkedList.

```
1
---
2
```

```
10
---
2 3 5 7 11 13 17 19 23 29
```

## 2

Дедлайн: (скорее всего)

Вводятся строки, последняя строка - `FINISH`.

Вывести строки, находящиеся между первой `BEGIN` и последней строкой `END`, в обратном порядке.

**Подсказка.** Для ввода очередной строки `scanner.nextLine()`.

```
abc
BEGIN
def
ghi
END
ijk
FINISH
---
ghi
def
```

```
BEGIN
abc
BEGIN
def
END
ghi
END
FINISH
--
ghi
END
def
BEGIN
abc
```

```
abc

def
FINISH
---
```

```
END
abc
BEGIN
FINISH
---
```
