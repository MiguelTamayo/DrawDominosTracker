angular
	.module('test')
	.controller('cont', function($scope){

		//options when opponent turn and there is tiles in draw pile
		/*
		1. select played domino
		2. drew from pile//if no pile change to skipped.
		3. view plausible pieces
		*/

		//GLOBAL DOMINO COUNTER
		$scope.numOfDom = 28;
		//TILE PLAYED HISTORY
		//NO NUMBERS COUNTER FOR EACH PLAYER

		//create array of opponents
		$scope.players=[];
		//fill array with the correct amount of opponents;
		$scope.createPlayers = function(np){
			$scope.players=[];
			$scope.players.push({name: 'Global Dominoes:',dominoes: createDominoSet()});
			if(typeof np != 'undefined'){
				for(var i=0; i<np; i++){
					$scope.players.push({name: 'Opponent '+(i+1)+':',dominoes: createDominoSet()});
				}
			}
		}
		
		//function that returns a set of dominos
		function createDominoSet(){
			//array of domino rows
			this.dominoes=[];
			//counter for domino id
			var idCounter=0;
			//loop to create dominoes
			for(var top = 0; top < 7; top++){
				var row={dominoes: []};
				for(var bottom=0; bottom <= top; bottom++){
					row.dominoes.push({ textValue:bottom+" | "+top,id:idCounter,visible: true,class:'domino'});
					idCounter+=1;
				}
				this.dominoes.push(row);
			}
			return this.dominoes;
		}


		$scope.typeOptions = [
    { name: '2', value: 1 }, 
    { name: '3', value: 2 }, 
    { name: '4', value: 3 }
    ];
    
    $scope.form = {type : $scope.typeOptions[0].value};

    	$scope.domNum = [
    { name: '0', value: 0 }, 
    { name: '1', value: 1 },
    { name: '2', value: 2 },
    { name: '3', value: 3 },
    { name: '4', value: 4 },
    { name: '5', value: 5 }, 
    { name: '6', value: 6 }
    ];
    
    $scope.domSkip = {type : $scope.domNum[0].value};


			$scope.dominoRows = this.dominoes;
			$scope.class = 'domino';

			$scope.globalDomRemove = function(pa,i){
				pa=pa.slice(1);
				$scope.numOfDom=$scope.numOfDom-1;
				for(var p =0;p<pa.length;p++){
					for(var dr=0;dr<pa[p].dominoes.length;dr++){
						for(var d=0;d<pa[p].dominoes[dr].dominoes.length;d++){
							if(pa[p].dominoes[dr].dominoes[d].id==i.id){
								pa[p].dominoes[dr].dominoes[d].class='selected';
								pa[p].dominoes[dr].dominoes[d].visible=false;
							}
						}
					}
				}
			}

			$scope.remDomByVal = function(dVal,pd){
				for(var dr=0;dr<pd.length;dr++){
						for(var d=0;d<pd[dr].dominoes.length;d++){
							if((pd[dr].dominoes[d].textValue).indexOf(dVal)!==-1){
								pd[dr].dominoes[d].class='selected';
								pd[dr].dominoes[d].visible=false;
							}
						}
					}
			}

			$scope.printDom = function(st1,pa){
				if(st1.visible){
				console.log(st1);
				st1.visible=false;
				}
			}
  
	});