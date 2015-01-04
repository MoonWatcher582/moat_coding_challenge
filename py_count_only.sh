SAVEIFS=$IFS
IFS=$(echo -en "\n\b")
count=0
for file in $(find . -name '*.py'); do
	currcount=$(wc -l "$file" | cut -d' ' -f1)
	count=$(($count + $currcount))
done;

echo TOTAL: $count
