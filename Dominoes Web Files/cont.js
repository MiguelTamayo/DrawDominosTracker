angular
	.module('test')
	.controller('cont', function($scope){
		//array of domino rows
		this.dominoes=[];
		//counter for domino id
		var idCounter=0;
		//loop to create dominoes
		for(var top = 0; top < 7; top++){
			var row={dominoes: []};
			for(var bottom=0; bottom <= top; bottom++){
				row.dominoes.push({ textValue:bottom+" | "+top,id:idCounter});
				idCounter+=1;
			}
			this.dominoes.push(row);
		}
			$scope.playerNumbers= [{value: 2, label: '2'}
							,{value: 3, label: '3'}
							,{value: 4, label: '4'}];

			$scope.dominoRows = this.dominoes;
			$scope.class = 'domino';


			$scope.TestClick = function(str1){
				if(typeof str1 != 'undefined'){
				console.log(str1.value.label);}
  }


  
	});