SAVEIFS=$IFS
IFS=$(echo -en "\n\b")
for file in $(find . -name '*.py'); do
	count=$(wc -l $file | cut -d' ' -f1)
	echo $count `basename $file`
done;	
IFS=$SAVEIFS

