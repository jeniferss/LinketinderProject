interface IAlert {
  type: "success" | "info" | "danger" | "warning";
  message: string;
}

class AlertHandler {
  show({ type, message }: IAlert) {
    const alertContainer = document.getElementById("alert");
    const wrapper = document.createElement("div");
    const alert = `
        <div class="alert alert-${type} alert-dismissible" role="alert">
            <div>${message}</div>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    `;

    wrapper.innerHTML = alert;
    alertContainer.append(wrapper);

    setTimeout(() => {
      wrapper.remove();
    }, 5000);
  }
}

export default AlertHandler;
