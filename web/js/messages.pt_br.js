window.ParsleyConfig = window.ParsleyConfig || {};

(function ($) {
  window.ParsleyConfig = $.extend( true, {}, window.ParsleyConfig, {
    messages: {
        defaultMessage: "Este valor parece estar inv&aacute;lido."
      , type: {
            email:      "Este valor deve ser um e-mail v&aacute;lido."
          , url:        "Este valor deve ser uma URL v&aacute;lida."
          , urlstrict:  "Este valor deve ser uma URL v&aacute;lida."
          , number:     "Este valor deve ser um n&uacute;mero v&aacute;lido."
          , digits:     "Este valor deve ser um d&iacute;gito v&aacute;lido."
          , dateIso:    "Este valor deve ser uma data v&aacute;lida (YYYY-MM-DD)."
          , alphanum:   "Este valor deve ser alfanum&eacute;rico."
        }
      , notnull:        "Este valor não deve ser nulo."
      , notblank:       "Este valor não deve ser branco."
      , required:       "Este valor &eacute; obrigat&oacute;rio."
      , regexp:         "Este valor parece estar inv&aacute;lido."
      , min:            "Este valor deve ser maior que %s."
      , max:            "Este valor deve ser menor que %s."
      , range:          "Este valor deve estar entre %s e %s."
      , minlength:      "Este valor &eacute; muito pequeno. Ele deve ter %s caracteres ou mais."
      , maxlength:      "Este valor &eacute; muito grande. Ele deve ter %s caracteres ou menos."
      , rangelength:    "O tamanho deste valor &eacute; inv&aacute;lido. Ele deve possuir entre %s e %s caracteres."
      , equalto:        "Este valor deve ser o mesmo."
      , minwords:       "Este valor deve possuir no m&iacute;nimo %s palavras."
      , maxwords:       "Este valor deve possuir no m&aacute;ximo %s palavras."
      , rangewords:     "Este valor deve possuir entre %s e %s palavras."
    }
  });
}(window.jQuery || window.Zepto));