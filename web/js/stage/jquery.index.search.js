
    $(function() {
        $( "#tags" ).autocomplete({
            source: function( request, response ) {
                $.ajax({
                    type: "post",
                    url: "indexSearch.action",
                    data: {searchInfo: $("#tags").val()},
                    dataType: "json",
                    success: function( data ) {
                        // alert(data.indexSearchJSON.couName)
                        response( $.map( data, function( item ) {
                            return {
                                // data: item,
                                label: item.couName,
                                value: item.couName
                            };
                        }));
                    }
                });
            },
            minLength: 1
            // focus: function( event, ui ) {
            //     return false;
            // },
            // select: function( event, ui ) {
            //     // var s=ui.item.label;
            //     // var labels=s.substring(0,s.indexOf("["));
            //     $( "#tags" ).val( ui.item.label );
            //     $( "#tags" ).val( ui.item.value );
            //     return false;
            // }
        });

    });



