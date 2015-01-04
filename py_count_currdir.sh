SAVEIFS=$IFS
IFS=$(echo -en "\n\b")
for file in *.py; do
	wc -l $file
done;
IFS=$SAVEIFS
