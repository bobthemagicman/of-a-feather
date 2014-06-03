
UserVoice=window.UserVoice||[];
(function(){
  var uv=document.createElement('script');
  uv.type='text/javascript';
  uv.async=true;
  uv.src='//widget.uservoice.com/j5TQubjBhrr7xaP3dXXM4Q.js';
  var s=document.getElementsByTagName('script')[0];
  s.parentNode.insertBefore(uv,s);
  
  UserVoice.push(['addTrigger', {
      // Options can also be set globally instead of on specific widgets
      trigger_style: 'icon', // icon or tab
      trigger_position: 'bottom-right',
      trigger_color: 'white',
      trigger_background_color: 'rgba(125, 186, 43, 0.9)',
      accent_color: '#7DBA2B',
      trigger_prevent_default_enabled: true,
      mode: 'contact', // contact, smartvote, or satisfaction
      menu_enabled: true, // Defaults to false for custom triggers, embedded widgets, autoprompts, and the show method
    }]);
})();
